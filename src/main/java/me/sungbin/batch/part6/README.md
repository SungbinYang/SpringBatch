## 성능 개선과 성능 비교
- SaveUserTasklet에서 User 40,000건 저장, Chunk Size는 1,000
- 성능 개선 대상 Step은 userLevelUpStep
- 아래 표 순서대로 실행
    * 예제를 만들고 성능 측정 후 비교
    * 3번 씩 실행
    * 환경에 따라 성능이 다를 수 있음

![](../../../../../resources/img/18.png)

## 성능 개선과 성능 비교
- ItemProcessor와 ItemWriter를 Async로 실행
- java.util.concurrent에서 제공되는 Future 기반 asynchronous
- Async를 사용하기 위해 spring-batch-integration 필요

![](../../../../../resources/img/19.png)