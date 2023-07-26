Taking into account that Swagger description was written in English, I hereby provide this task in Eng.

## Checklist
1. **Get all users info**
	1. get with role ADMIN
	2. get with role USER
2. **Greeting**
	1. get with role ADMIN
	2. get with role USER
    
*Presuming that there might be bug when developers only allows USER to get greeting, but not ADMIN; when supposingly there must be greeting for all types of users*

3. **Login**
	1. Username+password *(as only required fields)*
	2. Username/password empty
	3. Username different length
	4. Password different length
	5. Wrong username/password
4. **Create user**
	1. firstname/lastname/login/email/password empty
	2. firstname/middlename/lastname length 257
	3. login 8 spaces
	4. login 'a       '   *i personally think this is a bit of logic error
	5. login length 257
	6. email invalid (length 267, no @)
	7. password invalid (length 7/257, no uppercase, no lovercase, no number, no spec.char)
5. **Get user info**
	1. Admin role
	2. User1 gets user1 info
	3. User1 gets userN info
	4. Get nonexisting user info
6. **Delete user account**
	1. Admin role
	2. User1 deletes user1
	3. User1 deletes userN
	4. Delete nonexisting user
7. **Update user account**
	1. Missing any field
	2. Invalid any field
	3. Update user profile login to another existing login
	4. Admin updates user
	5. User1 updates user1
	6. User1 updates user2
	7. Update nonexisting user

***

## Test cases
### GET /users/all

> with precondition: *Registered as \<ROLE\>*

1. Receiving data as ADMIN. Positive.
2. Receiving data as USER. Negative.
3. Receiving data as nonauthorised user. Negative.

### GET /greet
> with precondition: *Registered as \<ROLE\>*
1. Receive greeting as ADMIN. Positive.
2. Receive greeting as USER. Positive.
3. nonauthorized??? Negative.

### GET /users/{userId}
> with precondition: *Registered as \<ROLE\>*
1. USER1. UUID not exists. Negative.
2. USER1. UUID of USER1. Positive.
3. USER1. UUID of USER2. Negative.
4. ADMIN. UUID of USER1. Positive.

### POST /login
1. Username, Password valid, user exists. Positive.
2. Username, Password valid, user doesn't exist. Negative.
3. Username invalid (empty). Negative.
4. Password invalid (empty). Negative.

### POST /users
1. firstname, lastname, login, email, password valid. user with this login doesn't exist yet. Positive.
2-6. one by one, each of the required fields are indalid or empty. Negative.
7. Required fields are valid, but login exists already. Negative.

## Testing via Postman
Logged as admin and received a token, which was afterwards used to get info about all users.
![Pasted image 20230725204731](https://github.com/WriteWrote/QA_RELEX2023_summerschool/assets/45429218/34a8a86e-8120-4833-b36c-6d51fb104d29)

Logged as a user and received 403 after trying to get info about all users.
![Pasted image 20230725204952](https://github.com/WriteWrote/QA_RELEX2023_summerschool/assets/45429218/edc9ca5d-40d2-4f72-b24f-482eb9f8f189)

Other test-cases would not be represented by photo, but they surely took their place.

***

## Autotesting
This is a humble attemp, so don't take it seriously, because I had never ever had any experience with autotests.

#### Some description:
- Specs -- public constrains such as specs for request, usercredentials, greeting and such.
- LoginTokenProvides -- not actually the test, some util-class for providing tokens.
- AdminAccessTest -- created purely out of curiosity
- GetMethodsTests contains only /greeting
- UserProfilesTests contains checking the valid, invalid creating of user. I'm not sure if it's correct interpretation of 'scenario', but it seemed to me right to test all possibilities in one method.
