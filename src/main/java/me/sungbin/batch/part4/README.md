## 회원 등급 프로젝트
- User 등급을 4개로 구분
    * 일반(NORMAL), 실버(SILVER), 골드(GOLD), VIP
- User 등급 상향 조건은 총 주문 금액 기준으로 등급 상향
    * 200,000원 이상인 경우 실버로 상향
    * 300,000원 이상인 경우 골드로 상향
    * 500,000원 이상인 경우 VIP로 상향
    * 등급 하향은 없음
- 총 2개의 Step으로 회원 등급 Job 생성
    * saveUserStep : User 데이터 저장
    * userLevelUpStep : User 등급 상향
- JobExecutionListener.afterJob 메소드에서 “총 데이터 처리 {}건, 처리 시간 : {}millis” 와 같은 로그 출력