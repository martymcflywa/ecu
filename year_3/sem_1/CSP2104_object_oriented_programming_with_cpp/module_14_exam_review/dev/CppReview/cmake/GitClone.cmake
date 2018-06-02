include_guard(GLOBAL)

find_package(Git REQUIRED)

include(CMakeParseArguments)

macro(git_clone)
  cmake_parse_arguments(_GIT_CLONE "QUIET" "URL;TAG;BRANCH;COMMIT;CHECKOUT_DIR" "" ${ARGN})
  get_filename_component(_GIT_CLONE_CHECKOUT_DIR_FULL "${_GIT_CLONE_CHECKOUT_DIR}" ABSOLUTE)

  if(_GIT_CLONE_TAG)
    set(_GIT_CLONE_COMMIT "${_GIT_CLONE_TAG}")
  endif()

  if(_GIT_CLONE_BRANCH)
    set(_GIT_CLONE_COMMIT "${_GIT_CLONE_BRANCH}")
  endif()

  if(NOT _GIT_CLONE_COMMIT)
    if(NOT _GIT_CLONE_QUIET)
      message(WARNING "No branch/tag/commit specified. Defaulting to `master`")
    endif()
    set(_GIT_CLONE_COMMIT "master")
  endif()

  if(_GIT_CLONE_QUIET)
    set(_GIT_CLONE_QUIET_ARG "-q")
  else()
    set(_GIT_CLONE_QUIET_ARG "")
  endif()

  if(EXISTS "${_GIT_CLONE_CHECKOUT_DIR_FULL}")
    execute_process(
            COMMAND             "${GIT_EXECUTABLE}" fetch ${_GIT_CLONE_QUIET_ARG} origin "${_GIT_CLONE_COMMIT}"
            COMMAND             "${GIT_EXECUTABLE}" checkout ${_GIT_CLONE_QUIET_ARG}  "${_GIT_CLONE_COMMIT}"
            COMMAND             "${GIT_EXECUTABLE}" submodule update ${_GIT_CLONE_QUIET_ARG} --remote
            WORKING_DIRECTORY   "${_GIT_CLONE_CHECKOUT_DIR_FULL}"
            OUTPUT_VARIABLE     _GIT_CLONE_OUTPUT
            ERROR_VARIABLE      _GIT_CLONE_OUTPUT
    )
  else()
    if(NOT _GIT_CLONE_QUIET)
        message(STATUS "Cloning ${_GIT_CLONE_URL} into ${_GIT_CLONE_CHECKOUT_DIR_FULL}")
    endif()

    execute_process(
            COMMAND             "${GIT_EXECUTABLE}" clone ${_GIT_CLONE_QUIET_ARG} --branch "${_GIT_CLONE_COMMIT}" --recursive "${_GIT_CLONE_URL}" "${_GIT_CLONE_CHECKOUT_DIR_FULL}"
            WORKING_DIRECTORY   "${CMAKE_CURRENT_LIST_DIR}"
            OUTPUT_VARIABLE     _GIT_CLONE_OUTPUT
            ERROR_VARIABLE      _GIT_CLONE_OUTPUT
    )
  endif()

  if(NOT _GIT_CLONE_QUIET)
      message(STATUS "${_GIT_CLONE_OUTPUT}")
  endif()
endmacro(git_clone)
