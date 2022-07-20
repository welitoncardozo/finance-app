# finance-app

### RUN PROJECT
- Need to install docker, minikube and istio; enable docker compose and kubernetes
- Start docker
- Run docker compose up
- Run minikube start
- Run minikube tunnel
- Apply files
  - kubectl apply -f ./kubefiles/namespace.yml
  - kubectl apply -f ./kubefiles/gateway.yml
  - kubectl apply -f ./user-service/kubefiles/destination-rule.yml
  - kubectl apply -f ./user-service/kubefiles/service.yml
  - kubectl apply -f ./user-service/kubefiles/deployment-blue.yml
  - kubectl apply -f ./user-service/kubefiles/deployment-green.yml
  - kubectl apply -f ./user-service/kubefiles/blue-virtual-service.yml OR kubectl apply -f ./user-service/kubefiles/green-virtual-service.yml
  - kubectl apply -f ./transaction-service/kubefiles/destination-rule.yml
  - kubectl apply -f ./transaction-service/kubefiles/service.yml
  - kubectl apply -f ./transaction-service/kubefiles/deployment-blue.yml
  - kubectl apply -f ./transaction-service/kubefiles/blue-virtual-service.yml
  - kubectl apply -f ./balance-service/kubefiles/destination-rule.yml
  - kubectl apply -f ./balance-service/kubefiles/service.yml
  - kubectl apply -f ./balance-service/kubefiles/deployment-blue.yml
  - kubectl apply -f ./balance-service/kubefiles/blue-virtual-service.yml
  - Obs: transaction-service and balance-service is running with 100% on blue version, but can change that