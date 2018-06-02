include(AddModule)
include(AddExternalModule)
include(InstallBlock)

set(CMAKE_MACOSX_RPATH 1)
set(gtest_force_shared_crt ON CACHE INTERNAL "")
set(ENABLE_INSTALL OFF)
add_external_module(
  NAME         GTest
  TARGETS      gtest_main gtest
  URL          https://github.com/google/googletest.git
  BRANCH       release-1.8.0
  CHECKOUT_DIR external/googletest
  DIRECTORY    external/googletest
  QUIET
)

## The target GTest::Main is expected to be provided via find_package(GTest)
## Since the library itself doesn't define it, we have to do it ourselves
add_library(GTest::Main  ALIAS gtest_main)
add_library(GTest::GTest ALIAS gtest)
add_library(GMock::Main  ALIAS gmock_main)
add_library(GMock::GMock ALIAS gmock)
set(GTEST_LANG_CXX11 1)

## Silence warnings treated as errors on MSVC 2017
target_compile_definitions(gtest      PUBLIC _SILENCE_TR1_NAMESPACE_DEPRECATION_WARNING)
target_compile_definitions(gtest_main PUBLIC _SILENCE_TR1_NAMESPACE_DEPRECATION_WARNING)
target_compile_definitions(gmock      PUBLIC _SILENCE_TR1_NAMESPACE_DEPRECATION_WARNING)
target_compile_definitions(gmock_main PUBLIC _SILENCE_TR1_NAMESPACE_DEPRECATION_WARNING)
set(ENABLE_INSTALL ON)
