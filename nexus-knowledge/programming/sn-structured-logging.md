# sn-structured-logging

Structured logging: import logging, json. class JSONFormatter(logging.Formatter): def format(self, record): return json.dumps({'time': self.formatTime(record), 'level': record.levelname, 'msg': record.getMessage(), 'module': record.module}). Handler = logging.StreamHandler(); Handler.setFormatter(JSONFormatter()).
