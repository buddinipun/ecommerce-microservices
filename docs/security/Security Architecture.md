Security Architecture Decision

I recommend:

Auth Service
    │
    ├── Login
    ├── Refresh Token
    ├── User Authentication
    │
    ▼
JWT Token
    │
    ▼
API Gateway
    │
    ▼
All Other Services

Meaning:

auth-service issues JWTs
API Gateway validates JWTs
Downstream services trust authenticated requests
platform-security becomes a reusable JWT validation library