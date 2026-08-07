#!/usr/bin/env python3
import sys, os
if getattr(sys, "frozen", False):
    os.chdir(os.path.dirname(sys.executable))
else:
    os.chdir(os.path.dirname(os.path.abspath(__file__)))
from launcher_v5 import Launcher
if __name__ == "__main__":
    Launcher()
