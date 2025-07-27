> **Important:**  
> The complete codebase is maintained in the `master` branch.  
> This `main` branch serves solely for documentation and informational purposes.

## About

This is an unofficial SDK for the Kyocera 701KC Android phone, created by reverse-engineering system apps and services.  
It provides raw interface definitions and wrappers that mimic or approximate Kyocera’s internal APIs, intended to help interact with device-specific features (like softkeys, endkey behavior, system dialogs, etc.).

I'm lazy, so most of the SDK relies on proxies and reflection instead of direct binding.  
A more complete, cleaner, and documented library may be created separately later.

⚠️ Work in progress. Some features may not work on other models or firmware versions.

---

## Features

- Softkey control (**tested**)  
- End key behavior customization (**tested**)  
- System resource mapping (icons, labels) (**untested**)  
- Backlight and LED indicator control (brightness, color, flashing)  

---

## Work in Progress

- Key event listener interfaces  
- Kyocera dialog scroll behavior  
- Proper abstraction/wrapping layer  

---

## Example

Some demo classes are included to show how to use key parts of the SDK.  
Minimal boilerplate — just enough to call into system services.

---

## Legal

This SDK is **not affiliated with or endorsed by Kyocera Corporation**.

- All interfaces and constants were manually recreated from publicly accessible behavior or reverse-engineered bytecode (e.g., from `boot.oat`).
- No original source code, assets, or proprietary SDK components are included.
- All constants (`int`, `String`, etc.) represent technical identifiers and are not subject to copyright protection under EU copyright law.
- The code provides **raw or proxy-based access** to services already exposed by the device's firmware and does not attempt to bypass any security restrictions.
- All bindings are minimal and designed to be transparent — they do not replicate full Kyocera APIs, only provide access to existing functionality.

Use at your own risk. Redistribution or integration in commercial products is not recommended.
