#Folders for input and output
$ParentFolder = "C:\Users\marty\Dropbox\Documents\CSI1241 - Systems Analysis - Assignment\Development\Submission CSI1241 A1 - Team To Be Confirmed\"
$ExportFile = "C:\Users\marty\Dropbox\Documents\CSI1241 - Systems Analysis - Assignment\Development\MD5\MD5_List.txt"

#Can use md5, sha1, and more depending on your .net version
$Type="md5"

#Looping through the files, generating hash, and appending to export file
#the -file is exclusive to powershell 3
$Files = Get-ChildItem $Parentfolder -Recurse -File

#Create Empty Array To Store Hashes
$Hashes=@()

$Files | ForEach-Object {

    $fs = new-object System.IO.FileStream $_.fullname, "Open"
    $algo = [type]"System.Security.Cryptography.$Type"
	$crypto = $algo::Create()
    $hash = [BitConverter]::ToString($crypto.ComputeHash($fs)).Replace("-", "")
    $fs.Close()
    
    $Hashes += ($_.fullname.substring(3) + " $hash")
    
}

$Hashes | Out-File $ExportFile -Force