--This is where you do the content scaling and some other stuff. You can look up to here for more -> http://docs.coronalabs.com/daily/guide/basics/configSettings/index.html

application =
{
    content =
    {
    	--You should always enter width/height values regardless of the orientation.
        width = 720,
        height = 1280,
        scale = "letterbox",	--other options are: zoomEven, adaptive, zoomStretch

        --There is also the imageSuffix option. If you would like to use different images for various resolutions, this is what you'll use.
        --imageSuffix =
        --{
        --    ["@2x"] = 1.5
            --high-resolution devices (Retina iPad, Kindle Fire HD 9", Nexus 10, etc.) will use @2x-suffixed images
            --devices less than 1200 pixels in width (iPhone 5, iPad 2, Kindle Fire 7", etc.) will use non-suffixed images
        --}
    }
}