
# Fluence OBD Dash - Full Starter Project

This project is a starter scaffold for the Renault Fluence OBD dashboard app. It includes:

- Jetpack Compose UI skeleton
- Bluetooth permissions
- Basic OBD manager and Bluetooth connector skeletons
- DTC manager for reading/clearing codes (simplified)
- Gauge composables
- Auto-start foreground service
- GitHub Actions workflow (builds debug APK)

## Important
This project intentionally does **not** include any code to bypass manufacturer security or unlock protected ECUs. Use OEM tools for that.

## How to use
1. Extract into a Git repo and push to GitHub.
2. GitHub Actions will build the debug APK automatically.
3. Enhance the app locally in Android Studio (or continue development in the repo).
