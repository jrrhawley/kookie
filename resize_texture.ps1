Add-Type -AssemblyName System.Drawing

$srcPath = "C:\Users\james\mods\kookie\src\main\resources\assets\kookie\textures\item\kookie.png"
$destPath = "C:\Users\james\mods\kookie\src\main\resources\assets\kookie\textures\item\kookie_16x16.png"

$src = [System.Drawing.Image]::FromFile($srcPath)
$dest = New-Object System.Drawing.Bitmap(16, 16, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
$g = [System.Drawing.Graphics]::FromImage($dest)
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
$g.DrawImage($src, 0, 0, 16, 16)
$g.Dispose()
$src.Dispose()
$dest.Save($destPath, [System.Drawing.Imaging.ImageFormat]::Png)
$dest.Dispose()

Write-Host "Resized texture saved to $destPath"
