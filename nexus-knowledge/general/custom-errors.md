# custom-errors

Custom: class MyError(Exception): pass. class ValidationError(MyError): def __init__(self, msg, field): self.field = field; super().__init__(msg). try: raise ValidationError('bad', 'email') except ValidationError as e: print(e.field).
