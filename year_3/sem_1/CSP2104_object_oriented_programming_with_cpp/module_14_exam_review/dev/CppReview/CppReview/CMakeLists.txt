cmake_minimum_required(VERSION 3.11)
project(CppReview LANGUAGES CXX)

find_package(review REQUIRED)
find_package(util REQUIRED)

add_executable(${PROJECT_NAME}
  src/main.cpp
)

target_compile_features(${PROJECT_NAME} 
  PRIVATE cxx_std_17
)

target_link_libraries(${PROJECT_NAME}
  PRIVATE
    review::review
    util::util
)

install(TARGETS ${PROJECT_NAME} DESTINATION bin)
