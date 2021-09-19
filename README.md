# SpringBatch

## 01. 스프링 배치란?
- 배치와 스프링 배치 이해
- 환경 설정 및 준비
- Hello, Spring Batch

## 02. 스프링 배치 아키텍쳐
- 스프링 배치 기본 구조
- 스프링 배치 테이블 구조와 이해
- Job, JobInstance, JobExecution, Step, StepExecution 이해
- 데이터 공유 ExecutionContext 이해

## 03. 스프링 배치 기초 이해하기
- Task 기반 배치와 Chunk 기반 배치
- JobParameters 이해
- @JobScope와 @StepScope 이해
- ItemReader interface 구조
- CSV 파일 데이터 읽기
- JDBC 데이터 읽기
- JPA 데이터 읽기
- ItemWriter interface 구조 이해
- CSV 파일 데이터 쓰기
- JDBC 데이터 쓰기
- JPA 데이터 쓰기
- ItemProcessor interface 구조 이해
- CSV 파일 데이터 읽고 MySQL DB에 insert하기
- 테스트 코드 작성하기
- JobExecutionListener, StepExecutionListener 이해
- StepListener 이해
- skip 예외처리
- retry 예외처리

## 04. 회원 등급 프로젝트
- 요구사항 분석
- 회원 데이터 H2 DB 저장하기
- 회원 주문 금약에 따른 등급 적용 Step 개발
- JobExecutionListener로 대상 회원 데이터 로그와 실행시간 측정

## 05. 주문금액 집계 프로젝트
- 요구사항 분석
- User와 Order Entity의 매핑관계 개발
