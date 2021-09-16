## 스프링 배치 기본 구조
![](../../../../../resources/img/01.png)

## 스프링 배치 기본 구조 - Job
 - Job은 JobLauncher에 의해 실행
 - Job은 배치의 실행 단위를 의미
 - Job은 N개의 Step을 실행할 수 있으며, 흐름(Flow)을 관리할 수 있다.
    * 예를 들면, A Step 실행 후 조건에 따라 B Step 또는 C Step을 실행 설정
 
## 스프링 배치 기본 구조 - Step
 - Step은 Job의 세부 실행 단위이며, N개가 등록돼 실행된다.
 - Step의 실행 단위는 크게 2가지로 나눌 수 있다.
    1. Chunk 기반 : 하나의 큰 덩어리를 n개씩 나눠서 실행
    2. Task 기반 : 하나의 작업 기반으로 실행
 - Chunk 기반 Step은 ItemReader, ItemProcessor, ItemWriter가 있다.
    * 여기서 Item은 배치 처리 대상 객체를 의미한다.
 - ItemReader는 배치 처리 대상 객체를 읽어 ItemProcessor 또는 ItemWriter에게 전달한다.
    * 예를 들면, 파일 또는 DB에서 데이터를 읽는다.
 - ItemProcessor는 input 객체를 output 객체로 filtering 또는 processing 해 ItemWriter에게 전달한다.
    * 예를 들면, ItemReader에서 읽은 데이터를 수정 또는 ItemWriter 대상인지 filtering 한다.
    * ItemProcessor는 optional 하다.
    * ItemProcessor가 하는 일을 ItemReader 또는 ItemWriter가 대신할 수 있다.
 - ItemWriter는 배치 처리 대상 객체를 처리한다.
    * 예를 들면, DB update를 하거나, 처리 대상 사용자에게 알림을 보낸다.