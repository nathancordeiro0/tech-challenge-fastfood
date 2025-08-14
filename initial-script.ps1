Write-Output "Iniciando o Minikube..."
minikube start

Write-Output "Instalando Ingress Controller (nginx)..."
minikube addons enable ingress

Write-Output "Aplicando arquivos do Kubernetes..."

$yamlPath = "C:\Users\natha\github.com\fast-food\k8s"

kubectl apply -f $yamlPath

Write-Output "Automação concluída em $(Get-Date)"
