# py-logging

logging best practices: 1) Use module-level: logger = logging.getLogger(__name__). 2) BasicConfig for apps. 3) Handlers: FileHandler, StreamHandler, RotatingFileHandler. 4) Formatters with %(asctime)s %(name)s %(levelname)s. 5) NullHandler for libraries. 6) Propagation control.
