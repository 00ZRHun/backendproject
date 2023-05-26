# Devotee
- Long membershipId

## Payment Information
- String receiptNo (eg. A12456)
- LocalDate receiptDate (eg. 04/30/2023)
- BigDecimal(2)? amount (eg. 80)
- Enum paymentMethod (Credit Card, Cash, Cheque)
- Enum bank (Affin, Alliance, AmBank, BSN, CIMB, Citibank, Direct Bank-In, EON, HLB, HSBC, MBB, OCBC, PBB, RHB, StanChart, TnG eWallet, UOB)
- String chequeNo

## contact information
- String nameEn (eg. Jerry Mattei)
- String nameCh (eg. 杰里.马特迪)
- String address
- String icOrPassportNo (eg. XXXXXX-XX-XXXX)
- String emailAddress (eg. email@address.com)
- String phoneNo
- String phoneNoHome
- String phoneNoOffice
- String postcode
- String district
- String state

## Data of Great Vow Lamp
- String DevoteeName (eg. XXX)
  - Q: 宝号?
- Text Remark
- LocalDate startDate (eg. 04/30/2023)
- LocalDate expiryDate (eg. 04/30/2024)
- String lampNo (A1242)
- String registrationDate (eg. 04/30/2022)


# GreatVowLamp

- String contactNameEn (eg. Jerry Mattedi)
- String contactNameCh (eg. 杰里.马特迪)
- String devoteeName (eg. xxxx)
- String lampNo (eg. A1242)
- String lampNoOld (eg. A1225)
- String icOrPasssport (eg. xxxxxx-xx-xxxx)
- String phone (eg. 251-661-5362)
- String phoneHome (eg. 251-661-5362)
- String receiptNo (eg. A12456)
- 
- Enum status (New, Expired, Not Expired, Blank)
* TODO: do validation bfr can add / edit row & col data

# Question
1. 供养者 -》 已故/过世的人? 
   1. (有 + 没有) /
   2. => devotee (灯上面的人)
2. 联络人 -》给钱的人 / devotee? ()
   1. => Customer (给钱的人)
3. 已过期，但没超过30天 (page 21) -> what status after expired over 30 days?
   1. => blank
4. lampNo: row+col? suffix + predix
   1. => wait to be confirmed
5. price -> permanent (RM1800)
   1. => got diff pricing plans