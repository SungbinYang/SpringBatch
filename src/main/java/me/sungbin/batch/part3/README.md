## Task 기반 배치와 Chunk 기반 배치
- 배치를 처리할 수 있는 방법은 크게 2가지
- Tasklet을 사용한 Task 기반 처리
    * 배치 처리 과정이 비교적 쉬운 경우 쉽게 사용
    * 대량 처리를 하는 경우 더 복잡
    * 하나의 큰 덩어리를 여러 덩어리로 나누어 처리하기 부적합
- Chunk를 사용한 chunk(덩어리) 기반 처리
    * ItemReader, ItemProcessor, ItemWriter의 관계 이해 필요
    * 대량 처리를 하는 경우 Tasklet보다 비교적 쉽게 구현
    * 예를 들면 10,000개의 데이터 중 1,000개씩 10개의 덩어리로 수행
        * 이를 Tasklet으로 처리하면 10,000개를 한번에 처리하거나, 수동으로 1,000개씩 분할
- reader에서 null을 return 할 때 까지 Step은 반복
- <INPUT, OUTPUT>chunk(int)
  * reader에서 INPUT 을 return
  * processor에서 INPUT을 받아 processing 후 OUPUT을 return
    * INPUT, OUTPUT은 같은 타입일 수 있음
  * writer에서 List<OUTPUT>을 받아 write
    ![](../../../../../resources/img/06.png)
- 배치를 실행에 필요한 값을 parameter를 통해 외부에서 주입
- JobParameters는 외부에서 주입된 parameter를 관리하는 객체
- parameter를 JobParameters와 Spring EL(Expression Language)로 접근
  * String parameter = jobParameters.getString(key, defaultValue);
  * @Value(“#{jobParameters[key]}”)
- @Scope는 어떤 시점에 bean을 생성/소멸 시킬 지 bean의 lifecycle을 설정
- @JobScope는 job 실행 시점에 생성/소멸
  * Step에 선언
- @StepScope는 step 실행 시점에 생성/소멸
  * Tasklet, Chunk(ItemReader, ItemProcessor, ItemWriter) 에 선언
- Spring의 @Scope과 같은 것
  * @Scope(“job”) == @JobScope
  * @Scope(“step”) == @StepScope
- Job과 Step 라이프사이클에 의해 생성되기 때문에 Thread safe하게 작동
- @Value(“#{jobParameters[key]}”)를 사용하기 위해 @JobScope와 @StepScope는 필수
