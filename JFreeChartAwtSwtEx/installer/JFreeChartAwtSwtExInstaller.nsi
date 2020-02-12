;NSIS Modern User Interface version 1.70
;JFreeChartAwtSwtEx Installer Script
;Written by Stephen Strenn

;--------------------------------
;Include Modern UI

  !include "MUI.nsh"

;--------------------------------
;General

  ;Name and file
  Name "JFreeChartAwtSwtEx"
  OutFile "JFreeChartAwtSwtExInstaller.exe"

  ;Default installation folder
  InstallDir "$PROGRAMFILES\SBCC\JFreeChartAwtSwtEx"
  
  ;Get installation folder from registry if available
  InstallDirRegKey HKCU "Software\JFreeChartAwtSwtEx" ""

;--------------------------------
;Interface Settings

  !define MUI_ABORTWARNING
	!define MUI_HEADERIMAGE "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\installer\SBCC Header.bmp"
	!define MUI_HEADERIMAGE_BITMAP_NOSTRETCH
	!define MUI_HEADERIMAGE_BITMAP "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\installer\SBCC Header.bmp"
	!define MUI_ICON "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\installer\setup.ico"
	!define MUI_UNICON "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\installer\setup.ico"

;--------------------------------
;Pages

  !insertmacro MUI_PAGE_LICENSE "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\installer\License.txt"
  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_DIRECTORY
  !insertmacro MUI_PAGE_INSTFILES
  
  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES
  
;--------------------------------
;Languages
 
  !insertmacro MUI_LANGUAGE "English"

;--------------------------------
;Installer Sections

Section "JFreeChartAwtSwtEx (required)" SecDummy

  SectionIn RO

  ;Files to be installed
  SetOutPath "$INSTDIR"
  
   File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\JFreeChartAwtSwtEx.jar"
   File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\JFreeChartAwtSwtEx.ico"
	File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\swt-win32-3138.dll"

	SetOutPath "$INSTDIR\lib"

  	File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\lib\jcommon-0.9.6.jar"
	File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\lib\jfreechart-0.9.21.jar"
	File "C:\Documents and Settings\Stephen Strenn\My Documents\My Work Documents\SBCC\CS165\Test Code\JFreeChartAwtSwtEx\lib\org.eclipse.swt.win32.win32.x86_3.1.0.jar"

	; Comment the next two lines out to create an installer that does not include a JRE (also see below for shortcut changes)
;	SetOutPath "$INSTDIR"
;	File /r "C:\Program Files\Java\jre1.5.0_04"
    
  ; Write the installation path into the registry
  WriteRegStr HKLM SOFTWARE\JFreeChartAwtSwtEx "Install_Dir" "$INSTDIR"
  
  ; Write the uninstall keys for Windows
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\JFreeChartAwtSwtEx" "DisplayName" "JFreeChartAwtSwtEx"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\JFreeChartAwtSwtEx" "UninstallString" '"$INSTDIR\uninstall.exe"'
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\JFreeChartAwtSwtEx" "NoModify" 1
  WriteRegDWORD HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\JFreeChartAwtSwtEx" "NoRepair" 1
  WriteUninstaller "uninstall.exe"
  

SectionEnd

; Optional section (can be disabled by the user)
Section "Start Menu Shortcuts"

  CreateDirectory "$SMPROGRAMS\JFreeChartAwtSwtEx"
  CreateShortCut "$SMPROGRAMS\JFreeChartAwtSwtEx\Uninstall.lnk" "$INSTDIR\uninstall.exe" "" "$INSTDIR\uninstall.exe"
  
  ; For an installer that includes a JRE, uncomment the next line and comment the one after it.
  ; For an installer w/no JRE, comment the next line and uncomment the one after it.
;  CreateShortCut "$SMPROGRAMS\JFreeChartAwtSwtEx\JFreeChartAwtSwtEx.lnk" "$INSTDIR\jre1.5.0_04\bin\javaw.exe" '-jar "$INSTDIR\JFreeChartAwtSwtEx.jar"' "$INSTDIR\JFreeChartAwtSwtEx.ico"
  CreateShortCut "$SMPROGRAMS\JFreeChartAwtSwtEx\JFreeChartAwtSwtEx.lnk" "$INSTDIR\JFreeChartAwtSwtEx.jar" "" "$INSTDIR\JFreeChartAwtSwtEx.ico"
SectionEnd

;--------------------------------
;Descriptions

  ;Language strings
  LangString DESC_SecDummy ${LANG_ENGLISH} "A test section."

  ;Assign language strings to sections
  !insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
    !insertmacro MUI_DESCRIPTION_TEXT ${SecDummy} $(DESC_SecDummy)
  !insertmacro MUI_FUNCTION_DESCRIPTION_END

;--------------------------------
;Uninstaller Section

Section "Uninstall"


  ; Remove registry keys
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\JFreeChartAwtSwtEx"
  DeleteRegKey HKLM SOFTWARE\JFreeChartAwtSwtEx
  DeleteRegKey /ifempty HKCU "Software\JFreeChartAwtSwtEx"

	; Remove shortcuts
  RMDir /r "$SMPROGRAMS\JFreeChartAwtSwtEx"

  ; Remove directories used
  RMDir /r "$INSTDIR"

SectionEnd