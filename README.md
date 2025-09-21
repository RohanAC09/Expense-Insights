# Expense-Insights (Spending-Insights) - Full Stack

<p align="center">
<a href="https://github.com/RohanAC09/Expense-Insights-Frontend" target="blank"><img width="478" height="250" alt="Screenshot from 2025-09-21 18-29-27" src="https://github.com/user-attachments/assets/af5decc5-7702-4291-b38b-f7a3d1c9b8f0" /></a>
<a href="https://github.com/RohanAC09/Expense-Insights-Frontend" target="blank"><img width="479" height="250" alt="Screenshot from 2025-09-21 18-31-43" src="https://github.com/user-attachments/assets/d335659a-ac3b-4556-b65c-bb0ef3c8cb66" /></a>
  <!-- <img width="855" height="447" alt="Screenshot from 2025-09-21 18-29-27" src="https://github.com/user-attachments/assets/af5decc5-7702-4291-b38b-f7a3d1c9b8f0" />
<img width="838" height="437" alt="Screenshot from 2025-09-21 18-31-43" src="https://github.com/user-attachments/assets/d335659a-ac3b-4556-b65c-bb0ef3c8cb66" /> -->
</p>
<p align="center">
<a href="https://github.com/RohanAC09/Expense-Insights-Frontend" target="blank"><img width="707" height="300" alt="Screenshot from 2025-09-20 14-31-14" src="https://github.com/user-attachments/assets/7d87b785-fd66-4d36-a22d-5d67fbf733c7" /></a>
<!-- <img width="1168" height="413" alt="Screenshot from 2025-09-20 14-31-14" src="https://github.com/user-attachments/assets/7d87b785-fd66-4d36-a22d-5d67fbf733c7" /> -->
</p>

---

## 🔗 Related Repositories
- Backend microservice - [Expense-Insights](https://github.com/RohanAC09/Expense-Insights)
- Frontend microservice - [Expense-Insights-Frontend](https://github.com/RohanAC09/Expense-Insights-Frontend)

---

### 🧩 Pre-requisites

1. MySQL or related Database
2. Docker
3. nvm - frontend microservices

<!-- 2. Keycloak or 3rd party login service -->
---

## 🚀 Running the Microservice

Follow the steps below to run this microservice locally.

### 1. Clone the Repository
```bash
git clone https://github.com/RohanAC09/Expense-Insights.git
cd Expense-Insights/
```

### 2. Build the image with Docker
```bash
sudo docker build -t expense-insights:1.0.7 .
```

### 3. Run the Docker image
```bash
sudo docker run -d -p 8080:8080 --name expense-insights-container expense-insights:1.0.7
```

### 🛑 Stopping the Container
```bash
docker stop expense-insights-container
docker rm expense-insights-container
```

---

## 📜 Note

Kindly follow the similar commands provided in the repo [Expense-Insights-Frontend](https://github.com/RohanAC09/Expense-Insights-Frontend) to start and run the frontend microservice.
