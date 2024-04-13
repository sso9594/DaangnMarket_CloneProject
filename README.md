# camp2022_btree
스마일게이트 개발 캠프 2022 - 윈터 개발 캠프 2기 - B-TREE

Notion: https://devcamp.notion.site/B-TREE-3997047c22c54d7e99ffb90158bba903?pvs=4

## 🌒 Project Outline
#### 협업과 실력 성장에 초점을 맞춘 주제
> **_개인의 성장_** <br>
> 스토브 플랫폼으로 주제를 정하였지만 
기술적으로나 벡앤드 면에서 보아서 성장할 방향이 좋지 않다고
생각되어서 <br>
플랫폼 형태를 유지 하되 많은 기능을 구현할 수 있는 당근 마켓 클론코딩으로 주제를 변경함
>

>**_개인 목표를 모두 달성가능한 주제_**<br>
>팀원 개인의 목표를 달성 가능한 플랫폼 형태의 서비스
>

>**_구현 가능성_** <br>
>기존에 있는 기능 뿐만 아니라 
여러가지 기능을 유동적으로 추가 할 수 있는 잠재력이 있음
>

## ⏰ Project Period
> 2022년 12월 24일 ~ 2023년 2월 24일 (팀 빌딩 및 아키텍처 설계 기간 포함 약 2개월)

## 📕 Tech Stack & Tools
### FRONTEND
<img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"> <img src="https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"> 

### BACKEND

#### - Post Server & GPS Server
<img src="https://img.shields.io/badge/java17-%23ED8B00?style=for-the-badge&logo=java17&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> ![](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?&style=for-the-badge&logo=IntelliJ%20IDEA&logoColor=white) ![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white) <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"> 

#### - Auth Server & Search Server
<img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white"> <img src="https://img.shields.io/badge/FastAPI-009688?style=for-the-badge&logo=FastAPI&logoColor=white"> <img src="https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/elasticsearch-005571?style=for-the-badge&logo=elasticsearch&logoColor=white"> <img src="https://img.shields.io/badge/logstash-005571?style=for-the-badge&logo=logstash&logoColor=white"> <img src="https://img.shields.io/badge/kibana-005571?style=for-the-badge&logo=kibana&logoColor=white">

#### - Cowork Tools
<div>
<img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white">
<img src="https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

## ⚙Architecture
![image](https://user-images.githubusercontent.com/58455389/224045656-b4fef72d-5c71-40a3-9186-5734cb6a9b6c.png)

## 🎞ERD
#### - Auth Server
![image](https://user-images.githubusercontent.com/58455389/224045969-7bc693c9-4fc8-4254-9ad5-441f9e2b5289.png)
#### - Post Server
![image](https://user-images.githubusercontent.com/58455389/224046105-840a6b7c-28f1-42cd-b954-5be896fa67f0.png) ![image](https://user-images.githubusercontent.com/58455389/224046186-c26897dd-8936-4469-bb96-831fddd51d77.png)

## 🔑나의 주요 기능 및 맡은 역할
- Post Server
  - 홈(판매글) 및 동네생활 CRUD 기능
  - 댓글 및 좋아요, 조회수 기능
  - 이미지 파일 AWS S3를 통해 관리
  - 판매 목록 및 카테고리 별 목록 출력
 
- Gps Server
  - Clent에서 좌표를 받으면 입력받은 주소와 실제 좌표 비교 (Gps Auth)
  - KakaoMap API를 통해 해당지역 주변의 게시글 
<!--
## 📱UI
### 로그인 및 회원가입
![image](https://user-images.githubusercontent.com/58455389/224046877-f9a664f5-fc45-49f5-84b3-d2df438a48ca.png) ![image](https://user-images.githubusercontent.com/58455389/224047095-5fc5dd43-bfcd-43e9-b9f0-5dcc602bb032.png)
### 홈 화면 (판매글) 및 동네생활
![image](https://user-images.githubusercontent.com/58455389/224047375-2b15f950-d7d8-4a88-9488-5ac38877364d.png) ![image](https://user-images.githubusercontent.com/58455389/224047479-018b920e-0681-4271-a4cb-3eaacf27ef21.png)
### 글쓰기 및 상세페이지
![image](https://user-images.githubusercontent.com/58455389/224047764-dd56bd9e-d062-4040-b553-4b11f9f8a494.png) ![image](https://user-images.githubusercontent.com/58455389/224047997-a06c9ce7-f7ef-426a-b2e8-9df0a36fd895.png)
-->
