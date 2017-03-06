  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting x = 5
          # Emitting x
          # Emitting 5
          movl $5, %esi
        movl %esi, %edi
        # Emitting y = x
          # Emitting y
          # Emitting x
        movl %edi, %edx
        # Emitting z = y
          # Emitting z
          # Emitting y
        movl %edx, %ecx
    movl $0, %eax
    leave
    ret
