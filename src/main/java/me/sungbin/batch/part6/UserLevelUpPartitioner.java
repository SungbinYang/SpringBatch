package me.sungbin.batch.part6;

import lombok.RequiredArgsConstructor;
import me.sungbin.batch.part4.UserRepository;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class UserLevelUpPartitioner implements Partitioner {

    private final UserRepository userRepository;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        long minId = userRepository.findMinId(); // 1번
        long maxId = userRepository.findMaxId(); // 40,000번

        long targetSize = (maxId - minId) / gridSize + 1;

        /**
         * partition0: 1 ~ 5,000
         * partition1: 5,001 ~ 10,000
         * ...
         * partition7: 35,001 ~ 40,000
         */
        Map<String, ExecutionContext> result = new HashMap<>();

        long number = 0;
        long start = minId;
        long end = start + targetSize - 1;

        while (start <= maxId) {
            ExecutionContext value = new ExecutionContext();
            result.put("partition" + number, value);

            if (end >= maxId) {
                end = maxId;
            }

            value.putLong("minId", start);
            value.putLong("maxId", end);

            start += targetSize;
            end += targetSize;
            number++;
        }

        return result;
    }
}
