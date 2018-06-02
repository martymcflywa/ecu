include(AddModule)
include(AddExternalModule)
include(InstallBlock)

set(ENABLE_INSTALL OFF)

add_external_module(
  NAME         Catch2
  TARGETS      Catch
  URL          https://github.com/catchorg/Catch2.git
  BRANCH       v2.1.2
  CHECKOUT_DIR external/catch2
  DIRECTORY    external/catch2
  QUIET
)

add_library(Catch2::Catch ALIAS Catch)

set(ENABLE_INSTALL ON)
