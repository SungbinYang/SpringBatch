## 주문금액 집계 프로젝트
- User의 totalAmount를 Orders Entity로 변경
    * 하나의 User는 N개의 Orders를 포함
- 주문 총 금액은 Orders Entity를 기준으로 합산
- `-date=2020-11` JobParameters 사용
  * 주문 금액 집계는 orderStatisticsStep으로 생성
    * `2020년_11월_주문_금액.csv` 파일은 2020년 11월1일~11월30일 주문 통계 내역
- `date` 파라미터가 없는 경우, orderStatisticsStep은 실행하지 않는다.