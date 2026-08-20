# jq-basics

jq filters: 1) .key: access field. 2) .[]: iterate array. 3) .[0]: first element. 4) select(.x > 5): filter. 5) {name: .name}: construct. 6) keys: list keys. 7) length: count. 8) group_by(.type): group. 9) sort_by(.date): sort. 10) pipe: |. Example: curl URL | jq '.results[].name'
