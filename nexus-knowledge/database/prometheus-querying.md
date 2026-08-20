# prometheus-querying

PromQL basics: 1) rate(http_requests_total[5m]): requests per second. 2) histogram_quantile(0.95, ...): p95 latency. 3) sum(rate(...)) by (service): aggregate. 4) up: target health. 5) alerting rules: for: 5m, labels, annotations.
