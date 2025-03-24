## 📦 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/freelancer-management.git
cd freelancer-management/frontend
```

### 2.Install Dependencies

```bash
npm install
```

### 3.Configure API Base URL

Make sure the frontend is pointing to the correct backend API.

In frontend/src/api.ts, update the base URL if your backend runs on a different IP or port:

```ts
// frontend/src/api.ts
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // 🔁 Change this if your backend URL differs
});

export default api;
```
If you're testing on a physical device (not browser), replace localhost with your computer's IP address on the local network:

```bash
baseURL: 'http://192.168.x.x:8080/api'
```

### 4. Start Expo Dev Server

```bash
npx expo start
```
Press w in the terminal to open the app in your browser.
