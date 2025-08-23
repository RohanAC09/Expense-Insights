# Expense-Insights (Spending-Insights) - Full Stack

## 🔗 Related Repositories
- Backend microservice - [Expense-Insights](https://github.com/RohanAC09/Expense-Insights)
- Frontend microservice - [Expense-Insights-Frontend](https://github.com/RohanAC09/Expense-Insights-Frontend)

---

### 🧩 Pre-requisites

1. MySQL or related Database
2. Keycloak or 3rd party login service
3. Docker
4. nvm - frontend microservices

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
