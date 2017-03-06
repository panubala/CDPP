  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 5
          # Emitting i0
          # Emitting 5
          movl $5, %esi
        movl %esi, %edi
        # Emitting i1 = read()
          # Emitting i1
          # Emitting read()
          pushl %esp
          call _scanf
          movl 0(%esp), %ecx
        movl %ecx, %edx
        # Emitting r1 = (i0 + i1)
          # Emitting r1
          # Emitting (i0 + i1)
            # Emitting i0
            # Emitting i1
          pushl %edi
          pushl %edx
          movl 4(%esp), %edi
          addl 0(%esp), %edi
        movl %edi, %ebx
        # Emitting write(r1)
