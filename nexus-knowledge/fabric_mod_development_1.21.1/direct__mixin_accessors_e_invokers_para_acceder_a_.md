# Direct: Mixin Accessors e Invokers para acceder a miembros privados

Category: Fabric mod development 1.21.1
Tags: direct-learned
Created: 2026-08-20T14:38:25.213316

---

Mixin ofrece @Accessor y @Invoker para leer/escribir campos y llamar metodos inaccesibles (private/protected) de la clase objetivo sin reflection. Un accessor mixin DEBE ser una interfaz anotada con @Mixin igual que un mixin normal, conteniendo solo metodos anotados con @Accessor o @Invoker. Convencion: interfaz <Target>Accessor en subpaquete accessor; getters/setters con prefijo del id del mod y separador $ o _, ej. @Accessor("campo") FieldType example_mod$getFieldName(). Limitacion: los accessors solo apuntan a campos y metodos; para override de metodos final, subclases de clases final o referenciar clases privadas se requiere access widening. Fuente: docs.fabricmc.net/develop/mixins/accessors.
