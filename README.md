#How to setup

## Start PostgreSQL
$ docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres

## create .pgpass
$ echo "*:5432:*:*:postgres" >> ~/.pgpass
$ chmod 600 ~/.pgpass

## install Client
$ sudo aptitude install postgres

# connect PostgreSQL
$ psql -h localhost -U postgres

# stop container
$ docker stop postgres