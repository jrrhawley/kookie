Add-Type -AssemblyName System.Drawing
$path = "C:\Users\james\mods\kookie\src\main\resources\assets\kookie\textures\item\kookie.png"
$img = [System.Drawing.Image]::FromFile($path)
Write-Host "Width: $($img.Width)"
Write-Host "Height: $($img.Height)"
Write-Host "PixelFormat: $($img.PixelFormat)"
$img.Dispose()
