
#!/bin/bash
if command -v gradle >/dev/null 2>&1; then
  gradle "$@"
else
  echo "Gradle not found. The workflow will use the Gradle action to build."
  exit 1
fi
