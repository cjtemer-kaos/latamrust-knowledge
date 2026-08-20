# architecture/app-as-container

S4 refactor: 5 services extracted from DirectorNexus to src/services/. NexusApp service registry in src/app/. DirectorNexus.__init__ now accepts optional app parameter. Pattern: app.register("routing", RoutingService(...)) then app.get("routing").classify(...). Bootstrap in src/app/bootstrap.py. Currently 2076 LOC (target 700). Backward compat preserved.
