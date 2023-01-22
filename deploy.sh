echo "Switching to frontend..."
git checkout frontend

echo "Building app..."
npm run build 

echo "Deploying files..."
scp -r build/* user@93.138.56.84:/var/www/93.136.114.142/

echo "Done!"