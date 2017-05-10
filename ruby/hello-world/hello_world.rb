# Hello World
class HelloWorld
  def self.hello(name = 'World')
    "Hello, #{name}!"
  end
end

puts HelloWorld.hello("Eric")