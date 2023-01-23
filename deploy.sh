echo "Switching to frontend..."
git checkout frontend

echo "Building app..."
npm run build 

echo "Deploying files..."
scp -r build/* user@192.168.1.25:/var/www/projektsensors.ddns.net/

echo "Done!"