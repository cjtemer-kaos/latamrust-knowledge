# clean-code-examples

Clean code examples:
# ANTES
def calc(a, b, c, d, e):
  return a * b + c - d / e
# DESPUÉS
def calculate_total_price(quantity, unit_price, discount, tax, exchange_rate):
  return quantity * unit_price + discount - tax / exchange_rate
# ANTES
if user.age >= 18:
  if user.active:
    allow_access()
# DESPUÉS
def can_access(user):
  return user.age >= 18 and user.active
if can_access(user):
  allow_access()
