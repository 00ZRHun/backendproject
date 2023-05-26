# Docs
1. Google Drive > SABS: https://drive.google.com/drive/folders/1SRSogU9Rjp0RiXX62QBoIMJlxYEOUvoa
2. Spaces > SABS GVL System: https://mail.google.com/mail/u/0/#chat/space/AAAAKlUVUsk
3. 20230501 SDD V1.0: https://docs.google.com/spreadsheets/d/1PtygYdSLuR40-CB7g_97oYzLVYL6AcB_/edit#gid=1364606057
4. 20230522 Software Design Document for SABS Version 1.0.1.pdf: https://drive.google.com/file/d/1zIdwJ2XzdAuTfuqab1xVRE4IsI3RN2cR/view
5. mockup: https://app.moqups.com/Q97ArHLKD7sVmARsQ3Vs5aoRNHTqNbnT/view/page/a4566d663
   - OR https://app.moqups.com/Q97ArHLKD7sVmARsQ3Vs5aoRNHTqNbnT/view/page/a135a1166
6. ERD: https://drive.google.com/file/d/1Ri4CAVvogZuodx0n93eC9NfH9oT283CA/view?usp=sharing
7. 

# Commands
1. pg_dump sabsbe > sabsbe.sql
   1. export sql into current path

# Question
- id type: Long or UUID?

# TODO

- [] ERD
  - [] wait for reply
- [] Database
  - [] wait for reply
- [x] setup Spring Boot with Postgres database
- [x] add Swagger API documentation
- [x] add soft delete
- [] Login module
  - [x] (Register)
  - [x] Login
  - [...] Forgot password
  - [] Fix
    - [] add username
    - [] use username & password to login
- [] GreatVowLamp
  - [] add relationship w devotee
  - [...] attributes
  - Long greatVowLamp ?
  - Enum status (expired, blank)
  - amount
  - lampNo
  - profile, such as changing mailing address
  - transaction history
  - expiry date - Once Devotees have made payment succesfully, does system auto renew lamp’s expiry date with additional 1 year ?
    - 
  - [x] Create /Add
  - [x] Read / View
  - [x] (Update)
  - [x] (Delete)
  - [...] Search
    - Search/Filter Criteria Option
  - [ON HOLD] Export CSV/PDF File Format
- [] devotee (Devotees)
  - [x] attributes
    - nameEn
    - nameCh
    - username? <- 供养者姓名 (vs name)
    - lampNo
    - lampNoOld
    - icOrPassport
    - phoneNo
    - phoneNoHome
    - receiptNo
    - status
    - membershipId
    - paymentId
      - receiptNo
      - receiptDate
      - amount
      - paymentMethod
      - bank
      - checkNo
    - contactId (STOP AT page 14)
      - 
    - greatVowLampId
  - [x] Create /Add
  - [x] Read / View
  - [x] (Update)
  - [x] (Delete)
  - [] Search
    - Search/Filter Criteria Option
  - [x] add enum for BankEnum & PaymentMethodEnum
  - [] Fix
    - 【】 change (devotee has) one to one (to GreatVowLamp)
    - 【】 add (customer has) one to many (to GreatVowLamp)
      - devotee -> 灯上面的人
      - customer -> 联系人 / 付钱的人
# backendproject
