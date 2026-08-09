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



#######################################

How authentication and autorization work flow would be

                 HTTP Request
                      │
                      ▼
          Authorization: Bearer JWT
                      │
                      ▼
          JwtAuthenticationFilter
                      │
                      ▼
              Validate JWT
                      │
              ┌───────┴───────┐
              │               │
            Invalid          Valid
              │               │
              ▼               ▼
        Continue        Extract Claims
                              │
                              ▼
                       UserPrincipal
                              │
                              ▼
                   SecurityContextHolder
                              │
                              ▼
                   Spring Security
                              │
                              ▼
                    Controller / API


##############################################

For an unauthenticated request:

Request
   │
   ▼
SecurityFilterChain
   │
   ▼
Authentication required
   │
   ▼
JwtAuthenticationEntryPoint
   │
   ▼
HTTP 401