# 🚗 Car Marketplace

A modern car marketplace application for buying and selling vehicles online.


## ✨ Features

- **Browse Cars** - Search and filter through available vehicles
- **List Your Car** - Easy car listing with photo upload
- **User Profiles** - Secure authentication and personal dashboards  
- **Messaging** - Direct communication between buyers and sellers
- **Favorites** - Save cars you're interested in
- **Responsive Design** - Works perfectly on all devices

## 🛠️ Tech Stack

- **Frontend**: React.js + Tailwind CSS
- **Backend**: Node.js + Express
- **Database**: MongoDB
- **Storage**: Cloudinary (images)
- **Authentication**: JWT

## 🚀 Quick Start

1. **Clone the repo**
   ```bash
   git clone https://github.com/fekher12wx/car-marketplace.git
   cd car-marketplace
   ```

2. **Install dependencies**
   ```bash
   # Frontend
   cd client && npm install
   
   # Backend
   cd ../server && npm install
   ```

3. **Environment setup**
   
   Create `.env` in server folder:
   ```env
   DATABASE_URL=mongodb://localhost:27017/car-marketplace
   JWT_SECRET=your-secret-key
   CLOUDINARY_CLOUD_NAME=your-cloudinary-name
   CLOUDINARY_API_KEY=your-api-key
   CLOUDINARY_API_SECRET=your-api-secret
   ```

4. **Run the app**
   ```bash
   # Start backend (from server folder)
   npm run dev
   
   # Start frontend (from client folder)
   npm start
   ```

5. **Open** http://localhost:3000

## 📁 Project Structure

```
car-marketplace/
├── client/          # React frontend
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   └── services/
│   └── package.json
├── server/          # Node.js backend  
│   ├── controllers/
│   ├── models/
│   ├── routes/
│   └── package.json
└── README.md
```

## 🎯 API Endpoints

```
POST /api/auth/register    # User registration
POST /api/auth/login       # User login
GET  /api/cars            # Get all cars
POST /api/cars            # Create car listing
GET  /api/cars/:id        # Get single car
PUT  /api/cars/:id        # Update car
DELETE /api/cars/:id      # Delete car
```

## 🚀 Deployment

### Frontend (Vercel)
1. Connect GitHub repo to Vercel
2. Add environment variables
3. Deploy automatically

### Backend (Heroku)
```bash
heroku create your-app-name
heroku config:set NODE_ENV=production
git push heroku main
```

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License.

---

**Made with ❤️ by [fekher12wx](https://github.com/fekher12wx)**
