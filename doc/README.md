# payment-service

Razorpay-oriented payment orders, platform/store payment config, and processed webhooks. Port **3006**, schema **`payment_svc`**.

Platform design: [System design](https://github.com/digi-carts/doc/blob/main/architecture/system-design.md)

## Domain

`PaymentOrder` records an upstream Razorpay order (`razorpay_order_id`), amount (integer, typically paise), currency, `PaymentType` (`PRODUCT` | `SUBSCRIPTION`), `reference_id` (order or subscription), optional `store_id` / `user_id`, and `PaymentStatus` (`CREATED` | `PAID` | `FAILED`).

Platform and per-store configs hold keys / KYC / online mode. `ProcessedWebhook` is an idempotency store for webhook event IDs.

Gateway routes `/api/payments/**` and `/api/webhooks/**`; controllers currently live under `/api/payment-orders`, `/api/platform-payment-config`, `/api/store-payment-config`, `/api/processed-webhooks`. Align paths before production.

## Tech stack

Java 21, Spring Boot 3.3.0, Web, JPA, Liquibase, PostgreSQL. Planned env: `RAZORPAY_KEY_ID`, `RAZORPAY_KEY_SECRET`.

## Data model

| Entity | Table | Notes |
|--------|--------|--------|
| `PaymentOrder` | `payment_order` | Unique `razorpay_order_id` |
| `PlatformPaymentConfig` | platform payment config | Global GET `/global` |
| `StorePaymentConfig` | store payment config | Lookup by store |
| `ProcessedWebhook` | processed webhooks | `{id}/exists` for idempotency |

## HTTP API

### Payment orders — `/api/payment-orders`

| Method | Path |
|--------|------|
| GET | `/api/payment-orders` |
| GET | `/api/payment-orders/{id}` |
| GET | `/api/payment-orders/razorpay/{razorpayOrderId}` |
| GET | `/api/payment-orders/store/{storeId}` |
| GET | `/api/payment-orders/user/{userId}` |
| POST | `/api/payment-orders` |
| PUT | `/api/payment-orders/{id}` |
| DELETE | `/api/payment-orders/{id}` |

### Platform config — `/api/platform-payment-config`

CRUD plus `GET /global`.

### Store config — `/api/store-payment-config`

CRUD plus `GET /store/{storeId}`.

### Webhooks ledger — `/api/processed-webhooks`

List, get, exists, create, delete.

### Health

`GET /health`

## Configuration

| Variable | Required | Default |
|----------|----------|---------|
| `DATABASE_URL` | yes | schema `payment_svc` |
| `PORT` | no | `3006` |
| `RAZORPAY_KEY_ID` / `RAZORPAY_KEY_SECRET` | prod | — |

## Local run

```bash
export DATABASE_URL="jdbc:postgresql://localhost:5432/digicarts?currentSchema=payment_svc"
mvn spring-boot:run
```

## CI/CD

`digi-cart-payment-service-dev` / `digi-cart-payment-service`.

## Related

- [order-service](https://github.com/digi-carts/order-service/blob/stage/doc/README.md)
- [platform-service](https://github.com/digi-carts/platform-service/blob/stage/doc/README.md)
- [api-gateway](https://github.com/digi-carts/api-gateway/blob/stage/doc/README.md)

## REST API reference

See [api.md](api.md) for every HTTP endpoint generated from Spring controllers.
