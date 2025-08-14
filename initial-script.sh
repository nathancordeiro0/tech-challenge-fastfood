echo "Iniciando o Minikube..."
minikube start

echo "Aplicando arquivos do Kubernetes..."

yamlPath="$HOME/github.com/fast-food/k8s"

kubectl apply -f "$yamlPath"

echo "Automação concluída em $(date)"