# my-kiosk-api

## Getting started
Web services to interact with `Digital Wallet` application.


## Prerequisites

* Java 11
* Gradle 7
* DB Postgres
* Docker and docker-compose

## Local deploy

### Start DB Postgres

1. Create a volume
```aidl
docker volume create mykiosk_pgdata
```

2. From db folder execute, start postgres and pgadmin services
```aidl
docker-compose up -d
```

3. Open pg_admin and login:
```aidl
Username: mykiosk@local.com
Password: oe98c7pCr2
```
   
4. Connect server with the follow data:

*  `POSTGRES_USER: mykiosklocal`
*  `POSTGRES_PASSWORD: kk84joRPC5`
*  `POSTGRES_DB: mykiosk`

4. Restore db using ./db/kiosk_schema file.

### Start services

#### Using CLI
Before to run, set the environment variables:
```aidl
DB_IP=xxx.xxx.xx.x
DB_USERNAME=mykiosklocal
DB_PASSWORD=kk84joRPC5
DB_NAME=mykiosk
```

Run:
```aidl
./gradlew booRun
```

#### Using docker-compose
Note. Update the version.

1. Build Jar
```aidl
./gradlew clean build
```

1. Build docker image
```aidl
docker build --no-cache -t evacacela/my-kiosk-api:1.2.0-SNAPSHOT -f Dockerfile .
```

1. Edit `docker-compose.yml` file and update `DB_IP` environment and image version.

2. From root folder, run `docker-compose up -d`
