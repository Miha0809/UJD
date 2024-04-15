# $HOME/.login* or similar files may first set $DEBUGINFOD_URLS.
# If $DEBUGINFOD_URLS is not set there, we set it from system *.url files.
# $HOME/.*rc or similar files may then amend $DEBUGINFOD_URLS.
# See also [man debuginfod-client-config] for other environment variables
# such as $DEBUGINFOD_MAXSIZE, $DEBUGINFOD_MAXTIME, $DEBUGINFOD_PROGRESS.

if (! $?DEBUGINFOD_URLS) then
    set prefix="/usr"
    set DEBUGINFOD_URLS=`sh -c 'cat "$0"/*.urls; :' "/etc/debuginfod" 2>/dev/null | tr '\n' ' '`
    if ( "$DEBUGINFOD_URLS" != "" ) then
        setenv DEBUGINFOD_URLS "$DEBUGINFOD_URLS"
    else
        unset DEBUGINFOD_URLS
    endif
    unset prefix
endif
