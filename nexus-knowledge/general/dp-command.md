# dp-command

Command Pattern: encapsular acción como objeto. class Command: def execute(self): ...; def undo(self): ...). Ventajas: undo/redo, logging de acciones, cola de comandos, transacciones. Ejemplo: TextEditor con InsertCommand, DeleteCommand, cada una con execute() y undo().
