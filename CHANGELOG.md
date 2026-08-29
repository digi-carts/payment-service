# Changelog

## [1.0.0] - 2026-08-29

### Features
- add JavaDoc, health aliases, and component tests

### Bug Fixes
- seed global platform payment config row and auto-create on missing
- remove liquibase default-schema to allow fresh DB bootstrap
- update controller @RequestMapping paths to match gateway routes
- add validCheckSum=ANY and runAlways to 001-create-schema changeset
- limit HikariCP pool to 2 connections (db-f1-micro max 25 total)
- disable Hibernate validation (Liquibase owns schema, uuid vs String mismatch)
- set liquibase-schema=public so schema is created before tracking tables
- add Cloud SQL postgres-socket-factory for Cloud Run connectivity

### Documentation
- add complete project documentation

### CI/Build
- retrigger prod deploy
- trigger first dev build
- use separate GCP project IDs for dev (digi-carts-dev) and prod (digi-carts)