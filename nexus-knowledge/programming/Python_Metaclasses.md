# Python Metaclasses

Metaclasses are classes of classes (type is the default metaclass). Use case: Singleton via metaclass overriding __call__; ORM models (SQLAlchemy declarative base); enum-like class creation. class SingletonMeta(type): _instances = {}; def __call__(cls,*a,**kw): if cls not in cls._instances: cls._instances[cls]=super().__call__(*a,**kw); return cls._instances[cls]. Modern Python prefers __init_subclass__ over metaclasses for simpler cases.
