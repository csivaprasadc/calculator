#!/bin/bash
test $(curl "192.168.0.100:8765/sum?a=1&b=2") -eq 3