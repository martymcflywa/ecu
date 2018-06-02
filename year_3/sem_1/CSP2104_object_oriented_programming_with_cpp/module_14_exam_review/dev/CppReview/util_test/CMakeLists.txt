cmake_minimum_required(VERSION 3.11)
project(util_test LANGUAGES CXX)

find_package(Catch2 REQUIRED)
find_package(util REQUIRED)

add_executable(${PROJECT_NAME} src/test1.cpp)
target_compile_features(${PROJECT_NAME} PRIVATE cxx_std_17)

target_link_libraries(${PROJECT_NAME}
  PRIVATE
    util::util
    Catch2::Catch
)

add_test(
  NAME    ${PROJECT_NAME}
  COMMAND $<TARGET_FILE:${PROJECT_NAME}>
)
